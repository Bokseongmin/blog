import { useState } from 'react'

import { Box, Button, Card, TextField, Typography } from '@mui/material'
import { signUpApi } from '../../../api';


interface props {
  setAuthView: (setAuth: boolean) => void,
}

export default function SignUp(props: props) {

  const [user_email, setUser_email] = useState<string>('');
  const [user_pw, setUser_pw] = useState<string>('');
  const [user_pw_check, setUser_pw_check] = useState<string>('');
  const [user_nick, setUser_nick] = useState<string>('');

  // 비구조화 할당
  const {setAuthView} = props

  const signUpHandler = async () => {
    const data = {
      "user_email": user_email,
      "user_pw": user_pw,
      "user_pw_check": user_pw_check,
      "user_nick": user_nick
    };

    const signUpRes = await signUpApi(data);

    if(!signUpRes) {
      alert("회원가입에 실패했습니다.");
      return;
    }

    if(!signUpRes.result) {
      alert("회원가입에 실패했습니다.");
      return;
    }

    alert("회원가입에 성공했습니다.");
    setAuthView(false);
  }
  return (
    <Card sx={{ minWidth: 275, maxWidth: "50vw", padding: 5 }}>

      <Box>
        <Typography variant='h4'>회원가입</Typography>
      </Box>
      <Box height={'50vh'}>
        <TextField fullWidth label="이메일" type="email" variant="standard" onChange={(e) => setUser_email(e.target.value)} />
        <TextField fullWidth label="비밀번호" type="password" variant="standard" onChange={(e) => setUser_pw(e.target.value)} />
        <TextField fullWidth label="비밀번호 확인" type="password" variant="standard" onChange={(e) => setUser_pw_check(e.target.value)} />
        <TextField fullWidth label="닉네임" variant="standard" onChange={(e) => setUser_nick(e.target.value)} />
      </Box>

      <Box component={'div'}>
        <Button fullWidth onClick={() => signUpHandler()} variant="contained">회원가입</Button>
      </Box>
      <Box component={'div'} display={'flex'} mt={2}>
        <Typography>이미 계정이 있으신가요?</Typography>
        <Typography fontWeight={800} ml={1} onClick={() => setAuthView(false)}>회원가입</Typography>
      </Box>
    </Card>
  )
}
