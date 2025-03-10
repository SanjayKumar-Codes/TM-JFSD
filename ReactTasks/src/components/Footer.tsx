import React from "react";

const Footer: React.FC = () => {
  return (
    <footer className="footer bg-dark text-light text-center py-3 mt-5">
      <p className="mb-0">© {new Date().getFullYear()} Food Ordering App. All rights reserved.</p>
      <p className="mb-0">
        Built with ❤️ using <strong>React + TypeScript</strong>
      </p>
    </footer>
  );
};

export default Footer;
