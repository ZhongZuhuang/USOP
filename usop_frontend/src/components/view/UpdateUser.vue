<script setup>

  import axios from 'axios';
  import {ref} from 'vue'
  import "../style/Input_Userinfo.css"
  import "../style/Card_Userinfo.css"

  const User_id = ref()
  const User_Origin_name = ref()
  const User_Origin_sex = ref()
  const User_Origin_school = ref()
  const User_Origin_hobbies = ref()
  const User_Origin_age = ref()

	const User_name = ref()
  const User_sex = ref()
  const User_school = ref()
  const User_hobbies = ref()
  const User_age = ref()

  const Status_show = ref(false)
  const Status_Finally = ref(false)
  const Url_imgsrc = ref()
  const Data_Response = ref()
  var Entity_User = ref()


  const Constructor_User=(username, sex, hobbies, school, age)=>{
    return Object(
      {
        username: username,
        sex:sex,
        hobbies:hobbies,
        school:school,
        age:age
      }
    )
  }  

  const GenerationImgSrc = (Gender) => {
    console.log(Gender)
    if (Gender == "Male"){
      Url_imgsrc.value = "./src/assets/icons/Male.svg"
      Status_show.value = true
    }else if(Gender == "Female"){
      Url_imgsrc.value = "./src/assets/icons/Female.svg"
      Status_show.value = true
    }else{
      Status_show.value = false
    }
  }

  const User_Get = (User_id) =>{
    axios.get("http://localhost:8080/users/"+User_id)
      .then(response => {
        User_Origin_name.value = response.data.user_info.username
        User_Origin_sex.value = response.data.user_info.sex
        User_Origin_school.value = response.data.user_info.school
        User_Origin_hobbies.value = response.data.user_info.hobbies
        User_Origin_age.value = response.data.user_info.age

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

  const User_Put = (User_id, Entity_User) =>{
	Entity_User = Constructor_User(User_name.value, User_sex.value, User_hobbies.value, User_school.value, User_age.value)
	console.log(Entity_User)
    axios.put("http://localhost:8080/users/"+User_id, Entity_User)
      .then(response => {
        Data_Response.value = JSON.stringify(response.data, null, 2)
        if(response.data.status == "success"){
          Status_Finally.value = true
        }else{
          Status_Finally.value = false
        }
      }
    )
  }

</script>

<template>

    <p class="Title_View">修改用户</p>
    <p class="Tips" v-if="Status_Finally">修改成功!</p>
    <div class="Card_SubView" v-else="Status_Finally">
      <div class="Input_UserInfo_Card">
			  <div class="Input_Info">
				  <p>用户名</p>
      	  <input type="text" v-model="User_name">
			  </div>

			  <div class="Input_Info">
				  <p>年龄</p>
      	  <input type="text" v-model="User_age">
			  </div>

			  <div class="Input_Info">
				  <p>性别</p>
      	  <input type="text" v-model="User_sex" @input="GenerationImgSrc(User_sex)">
			  </div>

			  <div class="Input_Info">
				  <p>学校</p>
      	  <input type="text" v-model="User_school">
			  </div>

			  <div class="Input_Info">
				  <p>爱好</p>
      	  <input type="text" v-model="User_hobbies">
			  </div>
      </div>

      <p class="Arrow">=》</p>
      
      <div class="Card_Userinfo">
        <div class="Group_Username">
          <h1 v-text="User_name"></h1>
          <img :src="Url_imgsrc" v-if="Status_show">
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

    </div>
      
    <div class="Card_Action">
      <input class="Input_ID" type="text" v-model="User_id" @input="User_Get(User_id), Status_Finally=false">
      <button class="Input_Submit" @click="User_Put(User_id, Entity_User)" type="submit">修改用户</button>
    </div>

</template>

<style>
  .Arrow {
    font-size: xx-large;
    text-align: center;
  }

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