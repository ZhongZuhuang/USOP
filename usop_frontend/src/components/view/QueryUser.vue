<script setup>

  import axios from 'axios';
  import {ref} from 'vue'
  import "../style/Card_Userinfo.css"

  const User_id = ref()
  const User_name = ref()
  const User_sex = ref()
  const User_school = ref()
  const User_age = ref()
  const User_hobbies = ref()
  const Status_show = ref(false)
  const Url_imgsrc = ref()
  const Data_Response = ref()

  const User_Get = (User_id) =>{
    axios.get("http://localhost:8080/users/"+User_id)
      .then(response => {
        User_name.value = response.data.user_info.username
        User_sex.value = response.data.user_info.sex
        User_school.value = response.data.user_info.school
        User_hobbies.value = response.data.user_info.hobbies
        User_age.value = response.data.user_info.age
        
        Data_Response.value = JSON.stringify(response.data, null, 2)
        GenerationImgSrc(response.data.user_info.sex)
      }
    )
  }
  
  const GenerationImgSrc = (Gender) => {
    if (Gender == "Male"){
      Url_imgsrc.value = "./src/assets/icons/Male.svg"
      Status_show.value = true
    }else{
      Url_imgsrc.value = "./src/assets/icons/Female.svg"
      Status_show.value = true
    }
  }

</script>

<template>

    <p class="Title_View">查询用户</p>

    <div class="Card_Userinfo" v-if="Status_show">

      <div class="Group_Username">
        <h1 v-text="User_name"></h1>
        <img :src="Url_imgsrc">
      </div>

      <div class="Hobbies">
        <img src="/src/assets/icons/Hobbies.svg">
        <h2 v-text="User_hobbies"></h2>
      </div>
    
      <div class="School">
        <img src="/src/assets/icons/School.svg">
        <h2 v-text="User_school"></h2>
      </div>

      <div class="Age">
        <img src="/src/assets/icons/Age.svg">
        <h2 v-text="User_age"></h2>
      </div>
      
    </div>

    <p class="Tips" v-else="Status_show">请在下方输入框内输入用户ID查询用户信息</p>
      
    <div class="Card_Action">
      <input class="Input_ID" type="text" v-model="User_id">
      <button class="Input_Submit" @click="User_Get(User_id)" type="submit">查询用户</button>
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