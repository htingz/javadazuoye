<template>
<div class="pingjia">
  <table border="0" class="tx" width="100%">
    <tr>
      <td>当前位置&gt;&gt;<a href="../index.html">首页</a>&gt;&gt;订单评价</td>
    </tr>
  </table>
  <br>
  <div style="text-align: center;">
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
                <td>订单评价</td>
              </tr>
              <tr>
                <td>
                  <input type="hidden" name="orderId" value=""/>
                  <textarea v-model="content" style="height: 500px;width: 80%;" id="evaluate" class="tx" name="evaluate" type="text">

                                </textarea>
                </td>
              </tr>
              <tr>
                <td colspan="2" align="right" style="padding-top:10px;">
                  <input class="tx" style="width:120px;margin-right:30px;" type="button"
                         @click="submit" value="完成">
                </td>
              </tr>
            </table>
          </form>
        </td>
      </tr>
      <tr valign="top">
        <td rowspan="2">

        </td>
      </tr>
    </table>
  </div>
</div>
</template>

<script>
import request from "@/utils/api";

export default {
  name: "pingjia",
  data() {
    return {
      content:null
    }
  },
  methods: {
    submit(){
      request.get("/zht/user/pingjia",{
        params:{
          content:this.content,
          id:this.$route.params.oid
        }
        ,
        headers: {
          "Content-Type":"application/json;charset=utf-8"
        },
        withCredentials : true
      }).then(res => {
        alert("评价成功！")
        this.$router.push("/query")
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