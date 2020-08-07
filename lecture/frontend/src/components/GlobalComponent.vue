<!--template: 틀을 만드는 것-->
<template>
    <button @click="addCounter">{{ counter }}</button>
</template>

<script>
export default {
  name: 'global-component',
  props: ['initialCounter'],
  template: '<button @click="addCounter">{{ counter }}</button>',
  data: function () {
    return {
      counter: this.initialCounter
    }
  },
  methods: {
    addCounter: function () {
      this.counter += 1
    }
  }
}
</script>
