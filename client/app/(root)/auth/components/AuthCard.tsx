interface AuthCardProps {
  children: React.ReactNode;
  title?: string;
}

export const AuthCard = ({ children, title }: AuthCardProps) => {
  return (
    <div className="flex justify-center">
      <div className="w-[400px] -mt-28 p-5 flex flex-col items-center gap-3 shadow-md">
        <div className="mb-5 text-xl font-semibold">{title}</div>
        {children}
      </div>
    </div>
  );
};
