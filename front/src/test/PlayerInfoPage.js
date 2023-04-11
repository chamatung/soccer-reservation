import React, { useEffect } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import Typography from "@material-ui/core/Typography";
import { inject, observer } from "mobx-react";
import { Today } from "@material-ui/icons";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    padding: theme.spacing(2),
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
}));

const PlayerInfoPage = inject("playerInfoStore")(
  observer(({ playerInfoStore }) => {
    const classes = useStyles();

    useEffect(() => {
      if (playerInfoStore.loginCheck()) {
        playerInfoStore.init();
      }
    }, []);
    const {
      birth,
      carrer,
      height,
      level,
      name,
      nation,
      playFoot,
      position,
      weight,
    } = playerInfoStore.info;

    const today = new Date();

    let age = today.getFullYear() - birth?.substring(0, 3) + 1;

    if (age < 0 || age > 100) age = 0;

    return (
      <div className={classes.root}>
        <Grid container spacing={3}>
          <Grid item xs={12}>
            <Paper className={classes.paper}>
              <Typography
                variant='h5'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                선수 정보
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                선수 이름
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {name}
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                나이
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {age}세
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                지역
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {nation}
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                생일
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {birth}
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12}>
            <Paper className={classes.paper}>
              <Typography
                variant='h5'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                선수 상세 정보
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                선수 등급
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {level ? level : "비기너"}
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                선수 경력
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {carrer}년
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                선호 포지션
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {position}
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                선수 발
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {playFoot}
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                몸무게
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {weight}kg
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                키
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {height}cm
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Paper className={classes.paper}>
              <Typography
                variant='h6'
                gutterBottom
                style={{ fontWeight: "bold", color: "black" }}
              >
                국적
              </Typography>
              <Typography
                variant='body1'
                style={{ fontWeight: "bold", color: "black" }}
              >
                {nation}
              </Typography>
            </Paper>
          </Grid>
        </Grid>
      </div>
    );
  })
);

export default PlayerInfoPage;
