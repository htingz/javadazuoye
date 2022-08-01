<template>
  <div class="home">
    <div id="building">
        <table width="100%" border="0">
          <tr>
            <td width="16%" height="500">&nbsp;</td>
            <td width="47%">&nbsp;</td>
            <td width="37%">&nbsp;</td>
          </tr>
          <tr>
            <td height="100">&nbsp;</td>
            <td>&nbsp;</td>
            <td align="center" style="vertical-align:top">
              <table width="100%" border="0">
                <tr >
                  <td>
                    <div>
                      <div style="text-align: center;">
                        <h1 style="color: #2e6da4">私教优选系统</h1>
                      </div>
                    </div></td>
                </tr>
                <tr   align="center">
                  <td><a href="/login/user" style="color:#FFF">会员中心</a></td>
                </tr>
                <tr align="center">
                  <td><a href="/login/coach" style="color: #FFF">教练中心</a></td>
                </tr>
                <tr align="center">
                  <td><a href="/login/admin" style="color: #FFF">管理中心</a></td>
                </tr>
                <tr align="center">
                  <td> <a href="/login/regist" style="color: #FFF" >我要注册</a><span style="color: #FF0000"> </span></td>
                </tr>
              </table>

            </td>
          </tr>
          <tr>
            <td height="21">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src


export default {
  name: 'Home',
  components: {

  },
  created() {
    this.load()
  },
  methods:{
    load(){
      if(this.$route.params.log==='begin'){
        console.log('1')
        alert("请重新登录！")
      }
    }
  }
}


</script>

<style scoped>

#building{
  background:url("../assets/image/1.jpg");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;}
</style>
