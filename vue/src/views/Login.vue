<template>
<div class="Login">
<!--  <input v-model="url" value="{{$route.params.role}}" />-->
  <el-form :rules="rules" ref="loginForm" :model="loginForm" class="logincon">

    <h3 class="logintitle" v-if="this.$route.params.role !== 'regist' ">{{$route.params.role}}登录</h3>
    <h3 class="logintitle" v-else>注册</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="loginForm.username" placeholder="请输入用户名"></el-input>

    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password" placeholder="请输入密码"></el-input>
    </el-form-item>
    <el-form-item prop="image" v-if="this.$route.params.role !== 'regist' ">
      <el-input type="text" autocomplete="false" v-model="loginForm.image" placeholder="点击图片刷新验证码" style="width: 60%;margin-right: 5px"></el-input>
      <img :src="captchaUrl" @click="updatecaptcha">
    </el-form-item>

    <el-checkbox v-model="checked" class="loginremeber" v-if="this.$route.params.role !== 'regist' ">记住我</el-checkbox>
    <div v-else>
      <el-radio v-model="sex" label="男" size="medium">男</el-radio>
      <el-radio v-model="sex" label="女" size="medium">女</el-radio>
    </div>
    <el-button type="primary" style="width: 100%" @click="submitLogin" v-if="this.$route.params.role !== 'regist' ">登录</el-button>
    <el-button type="primary" style="width: 100%" @click="submitregist" v-else>注册</el-button>
  </el-form>

</div>
</template>

<script>
import {ElMessage} from "element-plus";
import request from "@/utils/api";

export default {

  name: "Login",
  data(){
    return{
      sex:null,
      url:'',
      captchaUrl:'/zht/captcha?time='+ new Date(),
      loginForm:{
        username:'',
        password:'',
        image:null
      },
      checked:true,
      rules:{
        username:[{required:true,message:'请输入用户名',trigger:'blur'}],
        password:[{required:true,message:'请输入密码',trigger:'blur'}],
        image: [{required:true,message:'请输入验证码',trigger:'blur'}]
      }

    }
  },
  methods:{
    updatecaptcha(){
      this.captchaUrl='/captcha?time='+new Date();
    },

    submitLogin(){
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          request.get("http://localhost:9091/login/"+this.$route.params.role, {params:{
              username:this.loginForm.username,
              password:this.loginForm.password,
              image:this.loginForm.image
            },
            headers: {
              "Content-Type":"application/jsonp;charset=utf-8"
            },
            withCredentials : true
          } ).then(res=>{
            console.log(res.data)
            if(res.data==='1'&&this.$route.params.role==='user'){
              this.$router.push("/gallery")

            }else if(res.data==='1'&&this.$route.params.role==='coach'){
              this.$router.push("/manage")
            }else if(res.data==='1'&&this.$route.params.role==='admin'){
              this.$router.push("/center")
            }else if (res.code==="11"){
              alert("验证码不正确")
            }
            else{
              alert("用户名或密码不正确")
            }
          })
        } else{
          ElMessage.error('请输入所有字段!')
          return false
        }
      })
    },
    submitregist(){
    this.$refs.loginForm.validate((valid) => {
      if (valid) {
        request.get("http://localhost:9091/login/regist", {params:{
            username:this.loginForm.username,
            password:this.loginForm.password,
            sex:this.sex
          },
          headers: {
            "Content-Type":"application/jsonp;charset=utf-8"
          },
          withCredentials : true
        } ).then(res=>{
          console.log(res.code)
          if (res.code==='0')
            this.$router.push("/index/1")
          else {
            alert("用户已存在")
            this.loginForm.password=null;
            this.loginForm.username=null;
          }
        })
      } else  if(null == this.sex){
        ElMessage.error('请输入所有字段!')
        return false
      }
    })

  }
  }
}
</script>

<style scoped>
  .logincon{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 15px 35px 15px 35px;
    background: #fff;
    border:1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .logintitle{
    margin: 0px auto 40px auto;
    text-align: center;
  }
  .loginremeber{
    text-align: left;
    margin: 0px 0px 15px 0px;
  }
  .el-form-item__content{
    display: flex;
    align-items: center;
  }
</style>