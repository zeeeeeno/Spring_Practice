<template>
  <div class="Login">
    <h1>로그인</h1>
      <div id="app">
        <input v-model="id" />
        <button v-on:click="login">로그인</button>
        <br><input v-model="password" />
        <router-link :to="{name: 'SignUp'}" class="nav-link" active-class="active">
          회원가입
        </router-link>
      </div>
  </div>
</template>

<script>
/* eslint-disable no-unused-vars */

import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  data: function () {
    return {
      id: 'input your ID',
      password: 'input your Password'
    }
  },
  methods: {
    login: function () {
      this.message = this.message.split('').reverse().join('')
    },
    signUp: function () {
      this.message = this.message.split('').reverse().join('')
    }
  }
}
</script>
