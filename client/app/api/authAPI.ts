import axios from 'axios';

export const signup = async (
  username: string,
  password: string,
  emailAddress: string
) => {
  const respone = axios.post('http://localhost:8030/user/create', {
    username,
    password,
    emailAddress,
  });
  console.log(respone);
};
