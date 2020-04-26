package egg.lab.liteeditor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry

@SpringBootApplication
class LiteEditorApplication

fun main(args: Array<String>) {
    runApplication<LiteEditorApplication>(*args)
}

@Bean
fun addResourceHandler(registry: ResourceHandlerRegistry){
    registry.addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/","file:static/")
}