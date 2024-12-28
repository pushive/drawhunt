'use client';

import { useRouter } from 'next/navigation';
import React, { useEffect, useState } from 'react';

const Home = () => {
  const [text, setText] = useState<string>('');
  const router = useRouter();
  const moveToAuth = () => {
    router.push('/auth/login');
  };
  useEffect(() => {
    setText('Hello, World!');
  }, []);
  return (
    <div className="mt-5 flex justify-center">
      <div className="flex flex-col items-center">
        <div>Text</div>
        <div className="mt-10">{text}</div>
        <button
          className="mt-10 bg-gray-300 w-[100px] h-9 rounded-md drop-shadow-md"
          onClick={moveToAuth}
        >
          To Auth
        </button>
      </div>
    </div>
  );
};

export default Home;
