<template>
<div class="diary">
  <table border="0" class="tx" width="100%">
    <tr>
      <td>当前位置&gt;&gt;<a href="../index/1">首页</a>&gt;&gt;健身日记&gt;&gt;<button @click="logout()" >登出</button>></td>
    </tr>
  </table>
  <br>
  <div style="text-align: center;">
    <table border="0" width="80%" cellpadding="0" cellspacing="0">
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
                  <b><a href="#" @click="xieriji">写日记</a></b>
                </td>
              </tr>
              <tr>
                <td>
                    <table class="store">
                      <tr style="background:#D2E9FF;text-align: center;">
                        <td style="width: 10%">日期</td>
                        <td>健身日记</td>
                      </tr>
                      <tr v-for="i in journals">
                        <td v-text="timestampToTime(i.createdate)">
                        </td>
                        <td v-text="i.content">
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
  name: "diary",
  data() {
    return {
      search:null,
      journals:{
        id:null,
        userid:null,
        content:null,
        createdate:null
      }
    }
  },
  created() {
    this.load();
  },
  methods: {
    timestampToTime(timestamp) {
      var date = new Date(timestamp); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
      let Y = date.getFullYear() + '-';
      let M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
      let D = date.getDate() + ' ';
      let h = date.getHours() + ':';
      let m = date.getMinutes() + ':';
      let s = date.getSeconds();
      return Y + M + D;
    },

    logout(){
      request.post("http://127.0.0.1:9091/login/out").then(res => {
        console.log(res.data)
        this.$router.push("/index/1")
      })
    },

    load() {
      request.get("/zht/user/diary",{
        headers: {
          "Content-Type":"application/json;charset=utf-8"
        },
        withCredentials : true
      }).then(res => {
        this.journals=res.data
        if(res.data===undefined){
          this.$router.push("/index/begin")
        }
      })
    },
    select() {
      if (this.search === ''){
        this.load()
        return
      }
      request.get("/zht/user/evaluate2", {params:{name:this.search}}).then(res => {
        console.log(res.data)
        this.orders=res.data
      })
    },
    xieriji(){
      this.$router.push("/xieriji")
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