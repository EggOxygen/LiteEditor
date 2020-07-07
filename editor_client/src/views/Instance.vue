<template>
    <div class="admin">
        <el-container>
            <el-header>Instance</el-header>
            <el-main>
                <el-card class="box-card">

                    <el-table
                            :data="MulData"
                            border
                            style="width: 100%">
                        <el-table-column
                                fixed
                                prop="insID"
                                label="实例ID "
                        >
                        </el-table-column>
                        <el-table-column
                                label="操作"
                                width="300px"
                        >
                            <template slot-scope="scope">
                                <el-row>
                                    <!--                                    <el-button type="button" v-on:click="files()" style="height: max-content">文件管理 </el-button>-->
                                    <el-button @click="copyLink"
                                               :data-clipboard-text="fullAddress + '/userInstance?id=' +scope.row.insID"
                                               data-clipboard-action="copy">复制编辑URL
                                    </el-button>
                                </el-row>
                            </template>
                        </el-table-column>
                    </el-table>

                </el-card>
                <br>

                <div v-for="sinData in MulData">
                    <el-card class="box-card">
                        <el-row :gutter="20">
                            <p style="padding-left: 10px">实例ID : <span v-text="sinData.insID"></span></p>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="12">
                                <div class="ace-editor" :ref="'editor-' + sinData.insID"></div>
                            </el-col>
                            <el-col :span="12">
                                <p>HTML 内容展示区域</p>
                                <hr>
                                <iframe frameborder="0" scrolling="no" :id="'frame-' + sinData.insID"
                                        width="100%"></iframe>
                            </el-col>
                        </el-row>
                    </el-card>
                    <br>
                </div>

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
        name: "AdminInstance",
        data() {
            return {
                MulData: [],
                modePath: 'ace/mode/html',
                fullAddress: window.location.origin
            }
        },
        mounted() {

        },
        created: function () {

            for (let i = 0; i < this.$route.query.Num; i++) {
                axios.get('/instance/createInstance').then(
                    (resp) => {
                        this.MulData.push({
                            'insID': resp.data.data.insID,
                            'content': ""
                        })
                        // Show Resp
                        // console.log(resp.data)
                        // Init Ace Editor
                        this.$nextTick(() => {
                            // Show Refs
                            // console.log(this.$refs)
                            for (let i = 0; i < this.MulData.length; i++) {
                                ace.edit(this.$refs["editor-" + this.MulData[i].insID][0], {
                                    maxLines: Infinity,
                                    fontSize: 14,
                                    mode: this.modePath,
                                    tabSize: 4,
                                    enableBasicAutocompletion: true,
                                    enableSnippets: true,
                                    enableLiveAutocompletion: true,
                                })
                            }

                        })

                    }
                )
            }

            const refresh = setInterval(() => {

                for (let i = 0; i < this.MulData.length; i++) {
                    let _this = this;
                    axios.post('/instance/getContentByID', this.MulData[i])
                        .then(function (response) {
                            // console.log(response)
                            if (_this.MulData[i].content !== response.data.data.content) {
                                _this.MulData[i].content = response.data.data.content
                                // Set Value If Update
                                ace.edit(_this.$refs["editor-" + _this.MulData[i].insID][0]).setValue(response.data.data.content)
                                ace.edit(_this.$refs["editor-" + _this.MulData[i].insID][0]).clearSelection()
                                // Also Update HTML Selection
                                updateHTMLOutput(_this.MulData[i].content, 'frame-' + _this.MulData[i].insID)
                                // Update Iframe Height
                                const iframe = document.getElementById('frame-' + _this.MulData[i].insID);
                                if (iframe) {
                                    var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow
                                    if (iframeWin.document.body) {
                                        iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight
                                    }
                                }
                                console.log('CONTENT UPDATE')
                            } else {
                                console.log('NO UPDATE')
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        })
                }

            }, 500)

            // Clean Interval When Destroy
            this.$once('hook:beforeDestroy', () => {
                clearInterval(refresh);
            })
        },
        methods: {
            copyLink() {
                // console.log("INIT")
                let _this = this;
                let clipboard = new this.clipboard(".el-button");
                clipboard.on('success', function () {
                    _this.$message('复制成功');
                    clipboard.destroy();
                });

                clipboard.on('error', function () {
                    _this.$message('复制失败')
                    clipboard.destroy();
                });


            },
        }
    }

    // function files() {
    //     window.open("../FileManager/index")
    // }

    function updateHTMLOutput(content, id) {
        var ifr = document.getElementById(id)
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

    #external-frame {
        width: -webkit-fill-available;
    }
</style>