<template>
<div class="evaluate">
  <table border="0" class="tx" width="100%">
    <tr>
      <td>当前位置&gt;&gt;<a href="../index/1">首页</a>&gt;&gt;我的点评</td>
    </tr>
  </table>
  <br>
  <center>
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
                  教练姓名：
                </td>
                <td>
                  <input class="tx" type="hidden" name="id">
                  <input v-model="search" id="search" class="tx" name="fitnessName" type="text" placeholder="请输入健身教练名字"/>
                </td>
              </tr>
              <tr>
                <td colspan="2" align="right" style="padding-top:10px;">
                  <input class="tx" style="width:120px;margin-right:30px;" type="button"
                         @click="select" value="查询">
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
                  <b>我的点评：</b>
                </td>
              </tr>
              <tr>
                <td>
                  <table class="store">
                    <tr style="background:#D2E9FF;text-align: center;">
                      <td>订单号</td>
                      <td>教练姓名</td>
                      <td>评价内容</td>
                    </tr>
                    <tr v-for="i in orders">
                      <td v-text="i.orderid">
                      </td>
                      <td v-text="i.coachname">
                      </td>
                      <td v-text="i.evaluate">
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
  </center>
</div>
</template>

<script>
import request from "@/utils/api";

export default {
  name: "evaluate",
  data() {
    return {
      search:null,
      orders:{
        id:null,
        userid:null,
        username:null,
        coachid:null,
        coachname:null,
        orderid:null,
        payment:null,
        evaluate:null
      }
    }
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      request.get("/zht/user/evaluate",{
        headers: {
          "Content-Type":"application/json;charset=utf-8"
        },
        withCredentials : true
      }).then(res => {
        this.orders=res.data
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
.tx {
  BORDER-RIGHT: #006600 1px solid; BORDER-TOP: #006600 1px solid; FONT-SIZE: 9pt; BACKGROUND-IMAGE: url(/s_h/picture/bj1.gif); BORDER-LEFT: #006600 1px solid; COLOR: #006600; BORDER-BOTTOM: #006600 1px solid; FONT-FAMILY: "????"
}
.txt1 {
  BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BACKGROUND-IMAGE: url(/yuntong/picture/bj1.gif); BORDER-BOTTOM-WIDTH: 0px; FONT: 9pt "????"; COLOR: #000000; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none
}
.sec1 {
  BORDER-RIGHT: gray 1px solid; BORDER-TOP: #ffffff 1px solid; BORDER-LEFT: #ffffff 1px solid; CURSOR: hand; COLOR: #000000; BORDER-BOTTOM: #ffffff 1px solid; BACKGROUND-COLOR: #c0c0ff
}
.sec2 {
  BORDER-RIGHT: gray 1px solid; BORDER-TOP: #ffffff 1px solid; FONT-WEIGHT: bold; BORDER-LEFT: #ffffff 1px solid; CURSOR: hand; COLOR: #c060ff; BACKGROUND-COLOR: #ffffff
}
.main_tab {
  BORDER-RIGHT: gray 1px solid; BORDER-LEFT: #ffffff 1px solid; COLOR: #000000; BORDER-BOTTOM: gray 1px solid; BACKGROUND-COLOR:#ffffff
}
BODY {

}
TD {
  FONT-SIZE: 9pt; COLOR: #000000; LINE-HEIGHT: 150%; FONT-FAMILY: "????", "system"; TEXT-DECORATION: none
}
.t {
  FONT-SIZE: 9pt; COLOR: #000000; LINE-HEIGHT: 20px; FONT-FAMILY: "????", "system"; TEXT-DECORATION: none
}
.w {
  FONT-SIZE: 9pt; COLOR: #fffaed; LINE-HEIGHT: 15px; FONT-FAMILY: "????", "system"; TEXT-DECORATION: none
}
.style1 {
  COLOR: #ff3300
}
.en1 {
  FONT-SIZE: 8pt; FONT-FAMILY: "verdana", "arial", "helvetica", "sans-serif"; TEXT-DECORATION: none
}
A {
  COLOR: #000000; TEXT-DECORATION: none
}
A:visited {
  COLOR: #000000; TEXT-DECORATION: none
}
A:link {
  COLOR: #000000; TEXT-DECORATION: none
}
A:active {
  COLOR: #0066cc; TEXT-DECORATION: none
}
A:hover {
  COLOR: #cc0000; TEXT-DECORATION: underline
}
A.mnu {
  COLOR: #fffaed; TEXT-DECORATION: none
}
A.mnu:visited {
  COLOR: #fffaed; TEXT-DECORATION: none
}
A.mnu:link {
  COLOR: #fffaed; TEXT-DECORATION: none
}
A.mnu:active {
  COLOR: #fffaed; TEXT-DECORATION: none
}
A.mnu:hover {
  COLOR: #fffaed; TEXT-DECORATION: underline
}
.en {
  FONT-SIZE: 9pt; FONT-FAMILY: "verdana", "arial", "helvetica", "sans-serif"; TEXT-DECORATION: none
}
.go {
  BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; FONT-SIZE: 8pt; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid; FONT-FAMILY: "verdana", "arial", "helvetica", "sans-serif"; HEIGHT: 16px
}
.text {
  LINE-HEIGHT: 18px
}
.menubar {

}
.main {
  BORDER-RIGHT: 0px; BORDER-TOP: 0px; FONT-SIZE: 10pt; BORDER-LEFT: 0px; LINE-HEIGHT: 20px; BORDER-BOTTOM: 0px; FONT-FAMILY: "????"
}
.input {
  WIDTH: 150px; HEIGHT: 20px; BACKGROUND-COLOR: #ffffff
}
.del {
  TEXT-DECORATION: line-through
}
.style8 {
  COLOR: #ffffff
}
.enCopy {
  FONT-SIZE: 8pt; FONT-FAMILY: "verdana", "arial", "helvetica", "sans-serif"; TEXT-DECORATION: none
}
.tdrightline {
  BORDER-TOP-WIDTH: 1px; BORDER-RIGHT: #eaeaea 1px solid; BORDER-LEFT-WIDTH: 1px; BORDER-LEFT-COLOR: #eaeaea; BORDER-BOTTOM-WIDTH: 1px; BORDER-BOTTOM-COLOR: #eaeaea; BORDER-TOP-COLOR: #eaeaea
}
.2006input {
       BORDER-RIGHT: #d1d1d1 1px solid; BORDER-TOP: #d1d1d1 1px solid; BORDER-LEFT: #d1d1d1 1px solid; BORDER-BOTTOM: #d1d1d1 1px solid; BACKGROUND-COLOR: #ffffff
     }
</style>