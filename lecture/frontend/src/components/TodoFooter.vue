<template>
    <div>
        <h1>Todo Footer</h1>
        <button v-on:click="clearTodo">Delete ALL</button>
    </div>
</template>

<script>
export default {
  methods: {
    clearTodo () {
      console.log('clear todo')

      // $emit: store로 전송
      this.$emit('removeAll')
    }
  }
}
</script>

<style scoped>
  div {
    background-color: #006699
  }
</style>
