import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  Grid,
  Paper,
  Typography,
  TextField,
  Button,
  Link,
} from "@material-ui/core";
import { LockOutlined } from "@material-ui/icons";

const useStyles = makeStyles((theme) => ({
  root: {
    height: "100vh",
  },
  image: {
    backgroundImage: "url(https://source.unsplash.com/1600x900/?sports)",
    backgroundRepeat: "no-repeat",
    backgroundColor:
      theme.palette.type === "light"
        ? theme.palette.grey[50]
        : theme.palette.grey[900],
    backgroundSize: "cover",
    backgroundPosition: "center",
  },
  paper: {
    margin: theme.spacing(8, 4),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    backgroundColor: "rgba(255, 255, 255, 0.9)",
    padding: theme.spacing(4),
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
    backgroundColor: "#f44336",
    "&:hover": {
      backgroundColor: "#d32f2f",
    },
  },
  link: {
    color: "blue",
    textDecoration: "none",
    marginLeft: theme.spacing(2),
  },
}));

export default function SignInSide() {
  const classes = useStyles();
  const [login, setLogin] = useState({
    email: "",
    password: "",
  });

  const changeData = (e) => {
    const nextLogin = {
      ...login,
      [e.target.name]: e.target.value,
    };
    setLogin(nextLogin);
    console.log(nextLogin);
  };

  return (
    <Grid container component='main' className={classes.root}>
      <Grid item xs={false} sm={4} md={7} className={classes.image} />
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
        <div className={classes.paper}>
          <LockOutlined className={classes.avatar} />
          <Typography component='h1' variant='h5'>
            Sign in
          </Typography>
          <form className={classes.form} noValidate>
            <TextField
              variant='outlined'
              margin='normal'
              required
              fullWidth
              id='email'
              label='Email Address'
              name='email'
              autoComplete='email'
              autoFocus
              value={login.email}
              onChange={(e) => changeData(e)}
            />
            <TextField
              variant='outlined'
              margin='normal'
              required
              fullWidth
              name='password'
              label='Password'
              type='password'
              id='password'
              autoComplete='current-password'
              value={login.pw}
              onChange={(e) => changeData(e)}
            />
            <Button
              type='submit'
              fullWidth
              variant='contained'
              color='primary'
              className={classes.submit}
            >
              Sign In
            </Button>
            <Grid container justify='flex-end'>
              <Grid item>
                <Link href='/regist' variant='body2'>
                  Sign up
                </Link>
              </Grid>
            </Grid>
          </form>
        </div>
      </Grid>
    </Grid>
  );
}
