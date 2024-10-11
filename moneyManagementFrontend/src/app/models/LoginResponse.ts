export class LoginResponse {
  userId: number;
  message: string;

  constructor(userId: number, message: string) {
    this.userId = userId;
    this.message = message;
  }
}

