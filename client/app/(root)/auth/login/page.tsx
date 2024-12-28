'use client';

import Link from 'next/link';
import { AuthCard } from '../components/AuthCard';
import { useState } from 'react';
import { signIn } from '@/app/api';
import axios from 'axios';

const LoginPage = () => {
  const [username, setUsername] = useState<string>('');
  const [password, setPassword] = useState<string>('');

  const login = async (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    if (username && password) {
      try {
        const jwt = await signIn(username, password);
        const testData = await axios.get('http://localhost:8030', {
          headers: { Authorization: `Bearer ${jwt}` },
        });
        console.log(testData.data);
      } catch (error) {
        console.error(error);
      }
    }
  };

  return (
    <AuthCard title="Login">
      <form className="w-full flex flex-col gap-3">
        <input
          type="text"
          placeholder="Username"
          className="w-full border px-2 py-1"
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="text"
          placeholder="Password"
          className="w-full border px-2 py-1"
          onChange={(e) => setPassword(e.target.value)}
        />
        <button
          type="submit"
          className="w-full mt-5 bg-blue-500 text-white px-2 py-1"
          onClick={login}
        >
          Login
        </button>
      </form>
      <div className="w-full flex justify-end">
        <Link href={'/auth/sign-up'}>
          <div className="text-blue-500 hover:underline">Sign Up</div>
        </Link>
      </div>
    </AuthCard>
  );
};

export default LoginPage;
