<script setup>
    import Nav from "./Nav.vue";
    import View from "./View.vue";
    import {ref} from "vue"

    var pages = ref("")

    const ChangePages=(page)=>{
        pages.value=page
    }

</script>

<template>
    <Nav @pages="ChangePages"></Nav>
    <View :pages></View>
</template>

<style>
    #App {
        display: flex;
        flex-direction: row;
    }
</style>