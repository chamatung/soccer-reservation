import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import { AppBar, Toolbar, Typography, Button } from "@material-ui/core";
import { Link } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  title: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  link: {
    color: "#fff",
    textDecoration: "none",
    marginLeft: theme.spacing(2),
  },
}));

function MenuBar() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <AppBar position='static'>
        <Toolbar>
          <Button component={Link} to='/' className={classes.link}>
            소셜예약
          </Button>
          <Button
            component={Link}
            to='/stadium-reservation'
            className={classes.link}
          >
            구장예약
          </Button>
          <Button component={Link} to='/my-info' className={classes.link}>
            내 정보
          </Button>
        </Toolbar>
      </AppBar>
    </div>
  );
}

export default MenuBar;
