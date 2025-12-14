<script setup>
  const emit = defineEmits(['pages']) // 声明自定义事件
</script>

<template>
  <div class="nav">
    <h2 class="title">用户管理</h2>
    <div class="items">
      <li class="item" @click="emit('pages', 'add')">增加用户</li>
      <li class="item" @click="emit('pages', 'delete')">删除用户</li>
      <li class="item" @click="emit('pages', 'update')">修改用户</li>
      <li class="item" @click="emit('pages', 'query')">查询用户</li>
      <li class="item" @click="emit('pages', 'debug')">系统调试</li>
    </div>
    <div class="infos">
      <p class="info">Author : Michael Chung</p>
      <p class="info">Project : com.ctd.forntend</p>
      <p class="info">Version : 0.0.0</p>
    </div>
  </div>
</template>

<style>
  :root {
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  line-height: 1.5;
  font-weight: 400;

  color-scheme: light dark;
  color: rgba(255, 255, 255, 0.87);
  background-color: #242424;

  font-synthesis: none;
  text-rendering: optimizeLegibility;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.nav {
  height: 100vh;
  width: 15vw;
  border-radius: 0 6rem 0 0;
  background-color: #fff;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.nav h2 {
  color: #242424;
  text-align: center;
}

.nav li {
  background-color: #242424;
  border-radius: 1rem 0 0 1rem;
  margin:0.5rem 0 1rem 2rem;
  padding: 1rem 0 1rem 1rem;
  cursor: pointer;
}

.nav li:hover {
  background-color: #6c6c6c;
}

.nav .infos p {
  color: #242424;
  text-align: center;
  line-height: 0.6rem;
}
</style>