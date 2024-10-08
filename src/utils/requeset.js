import axios from "axios";
import router from "@/router"
import Cookies  from "js-cookie";

const request = axios.create({
    baseURL: 'http://localhost:9090',
    // baseURL: 'http://36.133.97.46:9090',
    timeout: 5000
})

request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json; charset=utf-8';

    // const admin= Cookies.get('admin');
    // if(!admin){
    //     router.push('/');
    // }
    return config;
},error => {
    return Promise.reject(error);
    }
);
request.interceptors.response.use(response => {
    let res = response.data;
    if(typeof res === 'string'){
        res = res ? JSON.parse(res) : res
    }
    return res;
},
    error => {
    console.log('err' + error)
        return Promise.reject(error);
    }
)

export default request;