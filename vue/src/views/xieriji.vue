<template>
<div class="xieriji">
  <table border="0" class="tx" width="100%">
    <tr>
      <td>当前位置&gt;&gt;<a href="../index.html">首页</a>&gt;&gt;健身日记</td>
    </tr>
  </table>
  <br>
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
              <td>健身日记</td>
            </tr>
            <tr>
              <td>
                                <textarea v-model="content" style="height: 500px;width: 80%;" id="fitnessDiary" class="tx" name="fitnessDiary" type="text">

                                </textarea>
              </td>
            </tr>
            <tr>
              <td colspan="2" align="right" style="padding-top:10px;">
                <input class="tx" style="width:120px;margin-right:30px;" type="button"
                       @click="load" value="完成">
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
</template>

<script>
import request from "@/utils/api";

export default {
  name: "xieriji",
  data() {
    return {
      content:null
      }
    },
methods: {
  load() {
    request.get("/zht/user/xieriji", {
      params:{
        content:this.content
      },
      headers: {
        "Content-Type": "application/json;charset=utf-8"
      },
      withCredentials: true
    }).then(res => {
      if (res.data === undefined) {
        this.$router.push("/index/begin")
      }
      this.$router.push("/diary")
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