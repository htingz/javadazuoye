<template>
<!--  <div id="nav">-->
<!--    <router-link to="/">首页</router-link>-->
<!--    <router-link to="/about">会员中心</router-link>-->
<!--    <router-link to="/about">教练中心</router-link>-->
<!--    <router-link to="/about">管理中心</router-link>-->
<!--  </div>-->
  <router-view/>
</template>

<style>

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
