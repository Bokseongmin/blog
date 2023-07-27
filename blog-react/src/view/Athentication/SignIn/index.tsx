import { Box, Button, Card, CardContent, TextField } from '@mui/material'
import axios from 'axios';
import React, { useState } from 'react'
import { useCookies } from 'react-cookie';

export default function SignIn() {
    const [user_email, setUser_email] = useState<string>('');
    const [user_pw, setUser_pw] = useState<string>('');
    const [cookies, setCookies] = useCookies();

    const signInHandler = () => {
        if (user_email.length === 0 || user_pw.length === 0) {
            alert("이메일 또는 비밀번호를 입력하세요.");
            return;
        }
        const data = {
            user_email: user_email,
            user_pw: user_pw
        }

        axios.post('http://localhost:4000/api/auth/signIn', data)
            .then((response) => {
                const resData = response.data.body;
                if(resData.body === null) {
                    console.log("로그인에 실패했습니다.");
                    return;
                }
                const {token, exprTime, userVo} = resData;
                const expires = new Date();
                expires.setMilliseconds(expires.getMilliseconds + exprTime);

                setCookies('token', token, {expires}) 
                alert("로그인 성공");
            })
            .catch((error) => {
                console.log(error);
                alert("로그인 중 오류가 발생했습니다.");
            })
    }
    return (
        <Card sx={{ minWidth: 275, maxWidth: '50vw' }}>
            <CardContent>
                <Box>
                    <TextField fullWidth type='email' variant='standard' onChange={(e) => setUser_email(e.target.value)} label='이메일' />
                    <TextField fullWidth type='password' variant='standard' onChange={(e) => setUser_pw(e.target.value)} label='비밀번호' />
                </Box>
            </CardContent>
            <CardContent>
                <Button fullWidth variant='contained' onClick={() => signInHandler()}>
                    로그인
                </Button>
            </CardContent>
        </Card>
    )
}
