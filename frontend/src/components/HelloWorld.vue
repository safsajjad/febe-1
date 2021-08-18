<template>
  <h1>{{ msg }}</h1>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    fetch("http://localhost:8000/api/backend1")
      .then((response) => response.text())
      .then((data) => {
          this.msg = data;
      });
  }
}
</script>