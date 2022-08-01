<template>
<div class="paid">
  <table border="0" class="tx" width="100%">
    <tr>
      <td>当前位置&gt;&gt;<a href="../index.html">首页</a>&gt;&gt;订单信息</td>
    </tr>
  </table>
  <br>
  <center>
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
                  <b>订单信息：</b>
                </td>
              </tr>
              <tr>
                <td>
                  <table class="store">
                    <tr style="background:#D2E9FF;text-align: center;">
                      <td>用户名</td>
                      <td>订单号</td>
                      <td>教练姓名</td>
                      <td>支付状态</td>
                      <td>操作</td>
                    </tr>
                    <tr v-for="i in orders">
                      <td v-text="i.username">
                      </td>
                      <td v-text="i.orderid">
                      </td>
                      <td v-text="i.coachname">
                      </td>
                      <td v-if="i.payment === 1">已支付
                      </td>
                      <td v-else>未支付
                      </td>
                        <td>
                            <a href="#"  @click="zifu(i.id)">支付</a>
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
  name: "paid",
  data() {
    return {
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
      request.get("/zht/user/paid",{
        headers: {
          "Content-Type":"application/json;charset=utf-8"
        },
        withCredentials : true
      }).then(res => {
        console.log(res.data)
        this.orders=res.data
        if(res.data===undefined){
          this.$router.push("/index/begin")
        }
      })
    },
    zifu(a){
      request.get("/zht/user/zifu2",{
        params:{
          id : a
        },
        headers: {
          "Content-Type":"application/json;charset=utf-8"
        },
        withCredentials : true
      }).then(res => {
        console.log(res.data)
        this.orders=res.data
        alert("支付成功")
      })
    }
    ,
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