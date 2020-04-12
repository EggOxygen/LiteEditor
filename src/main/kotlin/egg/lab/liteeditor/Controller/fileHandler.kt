package egg.lab.liteeditor.Controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Controller
@RequestMapping("/FileManager")
class fileHandler {

    // Get path from properties
    @Value("\${liteeditor.upload-path}")
    lateinit var filePath : String

    // Get Server Apache from properties
    @Value("\${liteeditor.apache-url}")
    lateinit var apacheURL : String

    /*
    * Date: 2020/4/10
    * Author: EggOxygen
    * Desc: upload a file into target location
    */
    @PostMapping("upload")
    @CrossOrigin
    fun upload(@RequestParam("file") file : MultipartFile) : Any{
        if (file.isEmpty){
            return ""
        }

        val fileName = file.originalFilename
        val fileLoc = File(filePath + fileName)
        try {
            file.transferTo(fileLoc)
            return "Files"
        }catch (e : Exception){
            e.printStackTrace()
        }
        return ""
    }

    /*
    * Date: 2020/4/10
    * Author: EggOxygen
    * Desc: return Files HTML
    */
    @GetMapping("/index")
    fun index():Any{
        return "Files"
    }

    /*
    * Date: 2020/4/10
    * Author: EggOxygen
    * Desc: return All files
    */
    @GetMapping("FilesList")
    @ResponseBody
    @CrossOrigin
    fun files():Any{
        var list = mutableListOf<MutableMap<String,String>>()

        File(filePath).listFiles().forEach {
            val map = mutableMapOf<String,String>()
            map.put("fileName",it.name)
            map.put("fileURL","${apacheURL}/${it.name}")
            list.add(map)
        }

        return list
    }
}