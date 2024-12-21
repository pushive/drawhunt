import * as Yup from 'yup';

export const signUpSchema = Yup.object({
  username: Yup.string()
    .required('Username is required')
    .min(3, 'User Name must be between 3 and 50 characters')
    .max(50, 'User Name must be between 3 and 50 characters'),
  password: Yup.string()
    .required('Password is required')
    .min(6, 'Password must be between 6 and 100 characters')
    .max(100, 'Password must be between 6 and 100 characters'),
  email: Yup.string()
    .required('Email address is required')
    .email('Please enter a valid email address'),
});
