import { Box, Button, Card, TextField, Typography } from '@mui/material'
import { useState } from 'react'
import { useCookies } from 'react-cookie';
import { userUserStore } from '../../../store';
import { signInApi } from '../../../api';

interface props {
    setAuthView: (setAuth: boolean) => void,
}

export default function SignIn(props: props) {
    const [user_email, setUser_email] = useState<string>('');
    const [user_pw, setUser_pw] = useState<string>('');
    const [cookies, setCookies] = useCookies();

    const { user, setUser } = userUserStore();

    // 비구조화 할당
    const { setAuthView } = props

    const signInHandler = async () => {
        if (user_email.length === 0 || user_pw.length === 0) {
            alert("이메일 또는 비밀번호를 입력하세요.");
            return;
        }
        const data = {
            user_email: user_email,
            user_pw: user_pw
        }

        const signInRes = await signInApi(data);
        console.log(signInRes);

        if(!signInRes) {
            console.log("로그인에 실패했습니다.");
            return;
        }

        if(signInRes.result) {
            console.log("로그인에 실패했습니다.");
            return;
        }

        const { token, exprTime, userVo } = signInRes.body;
        const expires = new Date();
        expires.setMilliseconds(expires.getMilliseconds() + exprTime);

        setCookies('token', token, { expires });
        setUser(userVo);
        alert("로그인 성공");
    };
    return (
        <Card sx={{ minWidth: 275, maxWidth: '50vw', padding: 5 }}>
            <Box>
                <Typography variant='h4'>로그인</Typography>
            </Box>
            <Box height={'50vh'}>
                <TextField fullWidth type='email' variant='standard' onChange={(e) => setUser_email(e.target.value)} label='이메일' />
                <TextField fullWidth type='password' variant='standard' onChange={(e) => setUser_pw(e.target.value)} label='비밀번호' />
            </Box>
            <Box component={'div'}>
                <Button fullWidth variant='contained' onClick={() => signInHandler()}>
                    로그인
                </Button>
            </Box>
            <Box component={'div'} display={'flex'} mt={2}>
                <Typography>신규 사용자 이신가요?</Typography>
                <Typography fontWeight={800} ml={1} onClick={() => setAuthView(true)}>회원가입</Typography>
            </Box>
        </Card>
    )
}
