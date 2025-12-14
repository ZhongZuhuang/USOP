<script setup>
  import AddUser from './components/view/AddUser.vue';
import DeleteUser from './components/view/DeleteUser.vue';
  import QueryUser from './components/view/QueryUser.vue';
import UpdateUser from './components/view/UpdateUser.vue';

  // 接收父组件传递的变量
  const props = defineProps({
  pages: {
    type: String,
    required: true,
    default: ''
    }
  })

  console.log(props.pages)
</script>

<template>
  <div class="view">
    <h1 v-if="props.pages === ''">主页</h1>
    <AddUser v-if="props.pages === 'add'">增加用户</AddUser>
    <DeleteUser v-if="props.pages === 'delete'">删除用户</DeleteUser>
    <UpdateUser v-if="props.pages === 'update'">修改用户</UpdateUser>
    <QueryUser v-if="props.pages === 'query'">查询用户</QueryUser>
    <h1 v-if="props.pages === 'debug'">系统调试</h1>
  </div>
</template>

<style>
  .Title_View {
    font-size: 2rem;
    margin: 0;
    padding-left: 1rem;
    border-left: white 0.8rem solid;
  }
</style>