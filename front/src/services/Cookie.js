// modern javascript cookie functions
// const Cookie = {
//   set: (name, value, options = {}) => {
//     options = {
//       path: "/",
//       ...options,
//     };

//     if (options.expires instanceof Date) {
//       options.expires = options.expires.toUTCString();
//     }

//     let updatedCookie =
//       encodeURIComponent(name) + "=" + encodeURIComponent(value);

//     for (let optionKey in options) {
//       updatedCookie += "; " + optionKey;
//       let optionValue = options[optionKey];
//       if (optionValue !== true) {
//         updatedCookie += "=" + optionValue;
//       }
//     }

//     document.cookie = updatedCookie;
//   },
//   get: (name) => {
//     let matches = document.cookie.match(
//       new RegExp(
//         "(?:^|; )" + name.replace(/([.$?*|{}()[\]\\/+^])/g, "\\$1") + "=([^;]*)"
//       )
//     );
//     return matches ? decodeURIComponent(matches[1]) : undefined;
//   },
//   delete: (name) => {
//     Cookie.set(name, "", {
//       "max-age": -1,
//     });
//   },
// };
const Cookie = {
  get: () => {
    const cookieString = document.cookie; // 현재 쿠키 문자열을 가져옴
    const cookieArray = cookieString.split(";"); // 쿠키 문자열을 세미콜론을 기준으로 나눔

    // let token = ""; // 추출한 JWT 토큰을 저장할 변수

    // // 쿠키 배열을 순회하며 JWT 토큰을 찾음
    // cookieArray.forEach((cookie) => {
    //   const cookiePair = cookie.split(":"); // 쿠키를 이름과 값의 쌍으로 나눔
    //   const cookieName = cookiePair[0].trim(); // 쿠키 이름
    //   const cookieValue = cookiePair[1].trim(); // 쿠키 값

    //   // JWT 토큰이라면 해당 값을 jwtToken 변수에 저장
    //   if (cookieName === "token") {
    //     token = cookieValue;
    //   }
    // });
    return cookieString;
  },
};

export default Cookie;
