import axios from "axios";
import { error } from "console";

export const signInApi = async (data: any) => {

    const res = await axios
        .post('http://localhost:4000/api/auth/signIn', data)
        .catch((error) => null);
    
    if(!res) return null;

    const result = res.data;
    return result;
}

export const signUpApi = async (data: any) => {

    const res = await axios
        .post('http://localhost:4000/api/auth/signUp', data)
        .catch((error) => null);
    
    if(!res) return null;

    const result = res.data;
    return result;
}