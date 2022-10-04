import axios from "axios";
import { useStore } from "vuex";

const store = useStore()
// axios 객체 생성
export default axios.create({
  // baseURL: "http://192.168.195.105:8080/api/",
  // baseURL: "http://172.16.101.80:8082/",
  // baseURL: "http://localhost:8181/api/",
  // baseURL: "http://j7a304.p.ssafy.io:8082/",
  baseURL: "https://j7a304.p.ssafy.io/api/",
  headers: {
    Authorization: `Bearer ${store.getter('token')}`,
    "Content-type": "application/json",
    // Authorization: 'Bearer ' + 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaXNzIjoid29vanUiLCJleHAiOjE2NjU0NTYxNjMsImlhdCI6MTY2NDE2MDE2M30.20Vw9UYQ_Z-UkUfWiNbHaI7bZdR3ZnaIzASxzzavfJGI8fopHKYVXxjSObHSF85E994cr3n8quLIsUnJ6EZwuQ'
  },
});
