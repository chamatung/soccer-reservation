import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  AppBar,
  Toolbar,
  Typography,
  Button,
  Container,
  Grid,
  Paper,
} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  logo: {
    height: 60,
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
}));

export default function Home() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <AppBar position='static'>
        <Toolbar>
          <img
            src={"https://source.unsplash.com/1600x900/?sports"}
            alt='PLAB Football'
            className={classes.logo}
          />
          <Typography variant='h6' className={classes.title}>
            Soccer Play
          </Typography>
          <Button color='inherit'>Logout</Button>
          <Button color='inherit'>Login</Button>
        </Toolbar>
      </AppBar>

      <div>{/* <DateBar style={{ padding: "20px" }} /> */}</div>
    </div>
  );
}
