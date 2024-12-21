const EmailConfirmation = () => {
  return (
    <div className="w-[600px] -mt-28 px-5 py-14 flex flex-col items-center gap-3 shadow-md">
      <h1 className="text-2xl font-semibold mb-4">Confirmation Email Sent</h1>
      <div>
        <p className="mb-4">
          Please check your email to activate your account.
        </p>
        <p>If you do not receive the email, please check your spam folder.</p>
      </div>
    </div>
  );
};
export default EmailConfirmation;
