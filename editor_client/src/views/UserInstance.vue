<template>
    <div class="user">
        <el-container>
            <el-header>User Instance</el-header>
            <el-main>
                <el-card class="box-card">
                    <el-row>
                        <p></p>
                        <p>实例辨识符 : <span v-text="insID"></span></p>
                        <!--                        <textarea id="url" v-text="insURL" hidden></textarea>-->
                    </el-row>
                </el-card>
                <br>
                <el-card class="box-card">
                    <el-row :gutter="20">
                        <el-col :span="12">
                            <div class="ace-editor" ref="ace" v-text="content"></div>
                        </el-col>
                        <el-col :span="12">
                            <p>HTML 内容展示区域</p>
                            <hr>
                            <iframe frameborder="0" scrolling="no" id="frame" width="100%"></iframe>
                        </el-col>
                    </el-row>
                </el-card>

            </el-main>
        </el-container>
    </div>
</template>

<script>

    import ace from 'ace-builds'
    import 'ace-builds/webpack-resolver'
    import 'ace-builds/src-noconflict/theme-monokai'
    import 'ace-builds/src-noconflict/mode-html'
    import 'ace-builds/src-noconflict/ext-language_tools'

    export default {
        name: "UserInstance",
        data() {
            return {
                insID: this.$route.query.id,
                content: defaultContent,
                aceEditor: null,
                modePath: 'ace/mode/html'

            };
        },
        methods: {},
        mounted() {
            this.aceEditor = ace.edit(this.$refs.ace, {
                maxLines: Infinity,
                // minLines: 10,
                fontSize: 14,
                mode: this.modePath,
                tabSize: 4,
                enableBasicAutocompletion: true,
                enableSnippets: true,
                enableLiveAutocompletion: true,
            })

            this.aceEditor.on('change', () => {
                let data = {"insID": this.insID, "content": this.aceEditor?.getValue()}
                console.log(data)
                axios.post('/instance/updateContentByID', data)
                    .then(function (response) {
                        // Nothing to do
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
                updateHTMLOutput(this.aceEditor?.getValue())
                var iframe = document.getElementById('frame')
                if (iframe) {
                    var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow
                    if (iframeWin.document.body) {
                        iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight
                    }
                }
            })

        }
    }

    // Default HTML Content
    var defaultContent =
        "<!DOCTYPE html>\n" +
        "<head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <title>Exercise Page</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "    \n" +
        "</body>\n" +
        "</html>"


    function updateHTMLOutput(content) {
        var ifr = document.getElementById('frame')
        var ifrw = (ifr.contentWindow) ? ifr.contentWindow : (ifr.contentDocument.document) ? ifr.contentDocument.document : ifr.contentDocument
        ifrw.document.open()
        ifrw.document.write(content)
        ifrw.document.close()
    }
</script>

<style scoped>
    .el-header {
        background-color: #455A64;
        color: white;
        text-align: center;
        line-height: 60px;
    }

    body {
        font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;

    }
</style>