import request from '@/utils/request';
// login
export function login(data) {
  return request({
    url: `/user/login`,
    data: {
      ...data,
    },
    method: 'post',
  });
}

// register
export function register(data) {
  return request({
    url: `/user/register`,
    data: {
      ...data,
    },
    method: 'post',
  });
}

// logout
export function logout(data) {
  return request({
    url: `/user/logout`,
    data: {
      ...data,
    },
    method: 'post',
  });
}