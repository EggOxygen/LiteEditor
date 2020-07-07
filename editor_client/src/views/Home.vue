<template>
    <div class="home">
        <el-container>
            <el-header>LiteEditor</el-header>
            <el-main>
                <el-card class="box-card">
                    <el-row>
                        <el-button type="primary">
                            <router-link :to="{name:'Instance',query:{Num:1}}">添加实例 [单人演示]</router-link>
                        </el-button>
                        <el-button type="primary">
                            <router-link :to="{name:'Instance',query:{Num:2}}">添加实例 [两人演示]</router-link>
                        </el-button>
                        <el-button type="primary">
                            <router-link :to="{name:'Instance',query:{Num:4}}">添加实例 [四人演示]</router-link>
                        </el-button>
                    </el-row>
                </el-card>
                <br>
                <el-card class="box-card">
                    <p>Made By EggOxygen</p>
                </el-card>
                <br>
                <el-card class="box-card">
                    <p>LiteEditor Version: 0.4.0 FE</p>
                </el-card>
            </el-main>
        </el-container>
    </div>
</template>

<script>


    export default {
        name: 'Home',
        components: {},
        methods: {
            newIns(Num) {
                window.location.href = "/adminInstance" + "?Num=" + Num
            }
        }
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

    a {
        color: white;
    }

    a:hover {
        color: white;
    }

    a {
        text-decoration: none;
    }
</style>