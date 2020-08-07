<template>
  <div class="home">
    <div id="header">
      <PRE>
        <router-link :to="{name: 'About'}" class="nav-link" active-class="active">
          About Us
        </router-link>
        <router-link :to="{name: 'Test'}" class="nav-link" active-class="active">
          Test Us
        </router-link>
        <router-link :to="{name: 'Home'}" class="nav-link" active-class="active">
          Home
        </router-link>
      </PRE>
    </div>

    <h1>This is a Test Pages</h1>
    <div id="app">

      <p v-if="seen">You can see it!</p>

      <!-- <p>태그의 id 값을 data 속성의 변수와 연결 -->
      <p v-bind:key=i v-for="(todo, i) in todos">
        {{ todo.text }}
      </p>
      <p> {{ message }} </p>

      <!-- v-on: 이벤트가 발생했을 때, 실행시킬 methods 지정 -->
     <button v-on:click="reverseMsg">Reverse Message</button>
      <p> {{ message }} </p>

      <!-- v-model 은 양식 입력을 위한 양방향 바인딩, 텍스트 입력 즉시 반영 -->
      <input v-model="message" /><br><br>
      <button @click="incCnt">{{ cnt }}</button><br>

      <p> 카운트 기반 순회 </p>
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key=i v-for="(idx, i) in count">
          <td> {{ msg }}</td>
          <td> {{ idx }}</td>
        </tr>
      </table>

      <p> list() 기반 순회 </p>
      <!-- border-collapse: 테두리와 셀 사이 간격 삭제 -->
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key=i v-for="(idx, i) in list()">
          <td> {{ msg }}</td>
          <td> {{ idx }}</td>
        </tr>
      </table>

      <p> (key, value) 기반 순회 </p>
      <!-- border-collapse: 테두리와 셀 사이 간격 삭제 -->
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key=key v-for="(value, key) in data">
          <td> {{ value }}</td>
          <td> {{ key }}</td>
        </tr>
      </table><br>

      <!-- this.$store 가 결국 Vuex 를 사용하겠다는 의미 -->
      <b>count: {{ this.$store.state.count }}</b><br>
      <b>count 의 제곱 : {{ this.$store.getters.count }}</b><br>
      <b>weight: {{ this.$store.getters.weight }}</b><br>
      <input type="button" @click="increment()" value="inc" />
      <input type="button" @click="decrement()" value="dec" /><br>
      <b>random: {{ this.$store.getters.random }} </b><br>
      <input type="button" @click="randomNumber()" value="random"/><br>

      <global-component v-bind:initial-counter="counter">
      </global-component><br>

      <local-component v-bind:num="value"></local-component>
      <button v-on:click="plus">Click</button><br>

    </div>
  </div>
</template>

<script>
import Vue from 'vue'
/* eslint-disable no-unused-vars */
// import store from '../store'
import cookies from 'vue-cookies'
import GlobalComponent from '../components/GlobalComponent.vue'
import LocalComponent from '../components/LocalComponent.vue'

// global-component 의 name 과 연결
Vue.component(GlobalComponent.name, GlobalComponent)

Vue.use(cookies)

export default {
  components: {
    'local-component': LocalComponent
  },
  data: function () {
    return {
      counter: 3,
      value: 1,
      msg: 'Test',
      count: 7,
      list: function () {
        var list = []
        for (var i = 1; i < this.count; i += 2) {
          list.push(i)
        }
        return list
      },
      message: 'Test Page',
      cnt: 0,
      seen: true,
      todos: [
        { text: 'Javascript' },
        { text: 'Golang' },
        { text: 'C++' }
      ],
      data: {
        bird: 'raven',
        animal: 'tiger',
        proj: 'cnn',
        fish: 'tuna',
        major: 'EE'
      }
    }
  },
  methods: {
    plus: function () {
      this.value++
    },
    reverseMsg: function () {
      this.message = this.message.split('').reverse().join('')
    },
    incCnt: function () {
      this.cnt++
    },
    increment: function () {
      this.$store.commit('increment')
      this.$cookies.set('value', this.$store.state.count, 30)
    },
    decrement: function () {
      this.$store.commit('decrement')
      this.$cookies.set('value', this.$store.state.count, 30)
    },
    randomNumber: function () {
      // dispatch 는 무조건 action 으로 간다.
      // commit 은 비동기 처리가 가능하다.
      this.$store.dispatch('generateRandomNumber')
    }
  },
  created: function () {
    this.$store.state.count = this.$cookies.get('value')
  }
}
</script>
