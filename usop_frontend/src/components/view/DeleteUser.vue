<script setup>

  import axios from 'axios';
  import {ref} from 'vue'
  import "../style/Card_Userinfo.css"

  const User_id = ref()
  const Status_Delete = ref(false)
  const Data_Response = ref()

  const User_Delete = (User_id) =>{
    axios.delete("http://localhost:8080/users/"+User_id)
      .then(response => {
        Data_Response.value = JSON.stringify(response.data, null, 2)
        console.log(response.data.status)
        if (response.data.status == "success"){
            Status_Delete.value = true
        }else{
            Status_Delete.value = false
        }
        console.log(Status_Delete.value)
      }
    )
  }

</script>

<template>

    <p class="Title_View">删除用户</p>

    <p class="Tips" v-if="Status_Delete">删除成功!</p>
    <p class="Tips" v-else="Status_Delete">请在下方输入框内输入欲删除的用户ID</p>
    
    <div class="Card_Action">
      <input class="Input_ID" type="text" v-model="User_id" @input="Status_Delete = false">
      <button class="Input_Submit" @click="User_Delete(User_id)">删除用户</button>
    </div>

</template>

<style scoped>

.Card_Action {
    display: flex;
    flex-direction: row;
    justify-content: right;
    align-items: center;
}

.Input_ID, .Input_Submit{
    height: 3rem;
    width: 15rem;
    font-size: larger;
    border: #828282 solid;
    border-radius: 10rem;
    position: relative;
}

.Input_ID:hover, .Input_Submit:hover{
    font-size: larger;
    border: #ffffff solid;
}

.Input_Submit {
    width: 6rem;
}

.Input_ID {
    position: relative;
    right: -6.2rem;
    padding-left: 1rem;
}

.Tips {
    font-size: 3rem;
    text-align: center;
}

</style>