import { useState, useEffect } from 'react';
import Navigation from '../../navigation'
import Authentication from '../../Authentication'
import Board from '../../board'
import { userUserStore } from '../../../store';
import { useCookies } from 'react-cookie';
import axios from 'axios';

export default function MainLayout() {

  const [boardRes, setBoardRes] = useState<string>('');
  const [cookies] = useCookies();
  const { user } = userUserStore();

  const getBoard = async (token: string) => {
    const reqOption = {
      headers: {
        "Authorization": `Bearer ${token}`
      }
    }
    await axios.get('http://localhost:4000/api/board/', reqOption).then((res) => {
      setBoardRes(res.data);
    }).catch((error) => '');
  }

  useEffect(() => {
    const token = cookies.token;
    if (token) {
      getBoard(token);
    } else {
      setBoardRes('');
    }
  }, [cookies.token])

  return (
    <>
      <Navigation />
      {boardRes ? (<Board />) : (<Authentication />)}
    </>
  )
}