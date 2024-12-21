import axios from 'axios';

export const getTestMessage = () => {
  const result = axios.get('http://localhost:8030');
  console.log(result);
};
