import React, { useState } from 'react'
import axios from 'axios'

import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

export default function SignUp() {

  const [user_email, setUser_email] = useState<string>('');
  const [user_pw, setUser_pw] = useState<string>('');
  const [user_pw_check, setUser_pw_check] = useState<string>('');
  const [user_nick, setUser_nick] = useState<string>('');

  const signUpHandler = () => {
    const data = {
      "user_email": user_email,
      "user_pw": user_pw,
      "user_pw_check": user_pw_check,
      "user_nick": user_nick
    };
    axios.post('http://localhost:4000/api/auth/signUp', data)
      .then((response) => {
      })
      .catch((error) => {
      })
  }
  return (
    <Card sx={{ minWidth: 275, maxWidth: "50vw" }}>
      <CardContent>
        <Box>
          <TextField fullWidth label="이메일" type="email" variant="standard" onChange={(e) => setUser_email(e.target.value)} />
          <TextField fullWidth label="비밀번호" type="password" variant="standard" onChange={(e) => setUser_pw(e.target.value)} />
          <TextField fullWidth label="비밀번호 확인" type="password" variant="standard" onChange={(e) => setUser_pw_check(e.target.value)}/>
          <TextField fullWidth label="닉네임" variant="standard" onChange={(e) => setUser_nick(e.target.value)} />
        </Box>
      </CardContent>
      <CardContent>
        <Button fullWidth onClick={() => signUpHandler()} variant="contained">Text</Button>
      </CardContent>
    </Card>
  )
}
