import React, { useEffect } from "react";
import { makeStyles } from "@material-ui/core/styles";
import { AppBar, Toolbar, Typography, Button } from "@material-ui/core";
import { inject, observer } from "mobx-react";

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
const Home = inject("homeStore")(
  observer(({ homeStore }) => {
    const classes = useStyles();

    useEffect(() => {
      homeStore.loadPlayer();
    }, []);

    const handleLogout = () => {
      homeStore.handleLogout();
    };

    const { info } = homeStore;

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
            <Typography>{info.name} 님</Typography>
            <Button
              color='inherit'
              onClick={() => {
                handleLogout();
              }}
            >
              Logout
            </Button>
          </Toolbar>
        </AppBar>

        <div>{/* <DateBar style={{ padding: "20px" }} /> */}</div>
      </div>
    );
  })
);
export default Home;
