'use client';

import { signup } from '@/app/api/auth';
import React, { useState } from 'react';

const SignUp = () => {
  const [username, setUsername] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const [email, setEmail] = useState<string>('');
  const submit = () => {
    if (username && password && email) {
      signup(username, password, email);
    }
  };

  return (
    <div className="flex justify-center">
      <div className="w-[300px] mt-[100px] p-5 flex flex-col items-center gap-3 border">
        <div className="text-xl font-semibold">Sign up</div>
        <input
          type="text"
          value={username}
          placeholder="Username"
          className="w-full border px-2 py-1"
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="text"
          value={password}
          placeholder="Password"
          className="w-full border px-2 py-1"
          onChange={(e) => setPassword(e.target.value)}
        />
        <input
          type="email"
          value={email}
          placeholder="E-mail"
          className="w-full border px-2 py-1"
          onChange={(e) => setEmail(e.target.value)}
        />
        <button
          className="w-full bg-blue-500 text-white px-2 py-1"
          onClick={submit}
        >
          Sign Up
        </button>
      </div>
    </div>
  );
};
export default SignUp;
