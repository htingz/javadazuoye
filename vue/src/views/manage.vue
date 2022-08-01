<template>
  <div class="manage">
    <table class="tx" style="width: 100%">
      <tr>
        <td>当前位置&gt;&gt;<a href="../index/1">首页</a>&gt;&gt;教练列表</td>
      </tr>
    </table>
    <br>
    <div style="text-align: center;">
      <table style="width: 80%;padding: 0" >
        <tr>
          <td rowspan="1">
            <form id="searchForm" action=""
                  method="post">
              <table style="width: 80%;border: 0;text-align: center;padding: 0" class="tx">
                <colgroup>
                  <col style="width: 20%;text-align: right">
                  <col style="width: 20%;text-align: left" >
                </colgroup>
                <tr>
                  <td style="background-color: #a0c0c0;padding-left:10px;text-align: left" colspan="2" >
                    <b>录入信息：</b>
                  </td>
                </tr>
                <tr>
                  <td>
                    教练姓名：
                  </td>
                  <td>
                    <input class="tx" type="hidden" name="id" value="">
                    <input v-model="users.name" id="fitnessName" class="tx" name="fitnessName" type="text" placeholder="请输入名字"/>
                    <div><span style="color: red; "></span></div>
                    <input type="hidden" id="fitnessId" name="fitnessId" value=""/>
                  </td>
                </tr>
                <tr>
                  <td>
                    年龄：
                  </td>
                  <td>
                    <input v-model="users.age" id="年龄" class="tx" name="age" type="text" placeholder="请输入健身教练年龄"/>
                  </td>
                </tr>
                <tr>
                  <td>
                    身高：
                  </td>
                  <td>
                    <input v-model="users.height" id="height" class="tx" name="height" type="text" placeholder="cm"/>
                  </td>
                </tr>
                <tr>
                  <td>
                    体重：
                  </td>
                  <td>
                    <input v-model="users.weight" id="weight" class="tx" name="weight" type="text" placeholder="kg"/>
                  </td>
                </tr>
                <tr>
                  <td>
                    工作时长：
                  </td>
                  <td>
                    <input v-model="users.work" id="workTime" class="tx" name="workTime" type="text" placeholder="小时"/>
                  </td>
                </tr>
                <tr>
                  <td>
                    本月是否拥有课时：
                  </td>
                  <td>
                    <input v-model="users.isclass" id="haveClass" class="tx" name="haveClass" type="text" placeholder="1或0"/>
                  </td>
                </tr>
                <tr>
                  <td>
                    课时价格：
                  </td>
                  <td>
                    <input v-model="users.cost" id="classCost" class="tx" name="classCost" type="text" placeholder="请输入课时价格"/>元
                  </td>
                </tr>
                <tr>
                  <td colspan="2" align="right" style="padding-top:10px;">
                    <input class="tx" style="width:120px;margin-right:30px;" type="button" @click="load" value="录入信息">
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
  name: "manage",
  data(){
    return {
      users:{
        id:null,
        name:"",
        sex:'',
        phone:'',
        age:null,
        height:null,
        weight:null,
        work:null,
        isclass: null,
        cost:null,
        evaluate:'',
        createDate:'',
        modDate: '',
      }
    }
  },
  created() {
  },
  methods: {
    load() {
      request.post("http://127.0.0.1:9091/coach",this.users,{
        headers: {
          "Content-Type":"application/jsonp;charset=utf-8"
        },
        withCredentials : true
      }).then(res => {
        console.log(res.data)

      })
    },
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