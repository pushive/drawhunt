import axios from 'axios';

export const signup = async (
  username: string,
  password: string,
  emailAddress: string
): Promise<void> => {
  await axios.post('http://localhost:8030/user/create', {
    username,
    password,
    emailAddress,
  });
};

type SignUpResponse = { token: string };
export const signIn = async (
  username: string,
  password: string
): Promise<string> => {
  const { data } = await axios.post<SignUpResponse>(
    'http://localhost:8030/user/login',
    {
      username,
      password,
    }
  );
  return data.token;
};

export const confirmNewUser = async (token: string): Promise<void> => {
  const data = await axios.get('http://localhost:8030/user/confirm', {
    params: { token },
  });
  console.log(data);
};
