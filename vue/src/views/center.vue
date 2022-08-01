<template>
<div class="center">
  <table border="0" class="tx" width="100%">
    <tr>
      <td>当前位置&gt;&gt;<a href="../index/1">首页</a>&gt;&gt;用户管理</td>
    </tr>
  </table>
  <br>
  <div>
    <table border="0" width="80%" cellpadding="0" cellspacing="0">
      <tr>
        <td rowspan="1">
          <form id="searchForm" action=""
                method="post">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx" align="center">
              <colgroup>
                <col width="20%" align="right">
                <col width="*%" align="left">
              </colgroup>
              <tr>
                <td bgcolor="a0c0c0" style="padding-left:10px;" colspan="2" align="left">
                  <b>查询条件：</b>
                </td>
              </tr>
              <tr>
                <td>
                  用户姓名：
                </td>
                <td>
                  <input class="tx" type="hidden" name="id">
                  <input v-model="search" id="search" class="tx" name="username" type="text" placeholder="请输入用户或者教练名字"/>
                </td>
              </tr>
              <tr>
                <td colspan="2" align="right" style="padding-top:10px;">
                  <input class="tx" style="width:120px;margin-right:30px;" type="button"
                         @click="selectone" value="查询">
                </td>
              </tr>
            </table>
          </form>
        </td>
      </tr>
      <tr valign="top">
        <td rowspan="2">
          <form action="" method="post" name="select">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx" align="center">
              <colgroup>
                <col width="20%" align="right">
                <col width="*%" align="left">
              </colgroup>
              <tr>
                <td bgcolor="a0c0c0" style="padding-left:10px;" colspan="1" align="left">
                  <b>用户列表：</b>
                </td>
              </tr>
              <tr>
                <td>
                  <table class="store">
                    <tr style="background:#D2E9FF;text-align: center;">
                      <td>用户昵称</td>
                      <td>用户密码</td>
                      <td>手机</td>
                      <td>地址</td>
                      <td>性别</td>
                      <td>姓名</td>
                      <td>会员积分</td>
                      <td>操作</td>
                    </tr>
                    <tr v-for="i in users">
                      <td v-text="i.username">
                      </td>
                      <td v-text="i.password">
                      </td>
                      <td v-text="i.phone">
                      </td>
                      <td v-text="i.address">
                      </td>
                      <td v-text="i.sex">
                      </td>
                      <td v-text="i.name">
                      </td>
                      <td v-text="i.points">
                      </td>
                        <td>
                          <a href="#" @click="deleteone(i.id)">删除</a>
                        </td>
                      </tr>
                  </table>
                </td>
              </tr>
            </table>
          </form>
        </td>
      </tr>
    </table>
  </div>
</div>
</template>

<script>
import request from "@/utils/api";

export default {
  name: "center",
  data(){
    return {
      search:"",
      users:{
        id:0,
        username:null,
        password:null,
        name:null,
        phone:null,
        sex:null,
        address:null,
        points:null,
        program:null,
        coach:null,
        CreateDate:null,
        ModDate:null
      }
    }
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      request.get("/zht/admin/selectall").then(res => {
        console.log(res.data)
        this.users = res.data
        if(res.data===undefined){
          this.$router.push("/index/begin")
        }
      }).catch(function (error) {
        if (error.response) {
          // 请求已发出，且服务器的响应状态码超出了 2xx 范围
          console.log(1)
          console.log(error.response.data);
          console.log(error.response.status);
          console.log(error.response.headers);
        } else if (error.request) {
          // 请求已发出，但没有接收到任何响应
          // 在浏览器中，error.request 是 XMLHttpRequest 实例
          // 在 node.js 中，error.request 是 http.ClientRequest 实例

          console.log(2)
          console.log(error.request);
          this.$router.push("/index/begin")
        } else {
          // 引发请求错误的错误信息
          console.log(3)
          console.log('Error', error.message);
        }
        console.log(error.config);
      })
    },
    selectone(){
      request.get("/zht/admin/selectone",{params:{name:this.search}}).then(res => {
        console.log(res.data)
        this.users = res.data
      })
    },
    deleteone(a){
      request.get("/zht/admin/deleteone",{params:{id:a}}).then(res => {
        console.log(res.data)
        alert("删除成功！")
        this.users=res.data
      })
    }

  }
}
</script>

<style scoped>
.tx td {
  padding: 3px;
}

.store {
  width: 100%;
  border: 1px solid gray;
  border-collapse: collapse;
}

.store td {
  border: 1px solid gray;
  padding: 3px;
}

.store a {
  text-decoration: underline;
  color: blue;
}
</style>