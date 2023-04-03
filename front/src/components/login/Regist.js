import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  Grid,
  Paper,
  Typography,
  TextField,
  Button,
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  Link,
  InputAdornment,
} from "@material-ui/core";
import apiService from "../../services/ApiService";
import { useNavigate } from "react-router-dom";

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
}));

const positions = ["Forward", "Midfielder", "Defender", "Goalkeeper"];
const regions = [
  "Seoul",
  "Busan",
  "Incheon",
  "Daegu",
  "Gwangju",
  "Daejeon",
  "Ulsan",
  "Sejong",
  "Gyeonggi-do",
  "Gangwon-do",
  "Chungcheongbuk-do",
  "Chungcheongnam-do",
  "Jeollabuk-do",
  "Jeollanam-do",
  "Gyeongsangbuk-do",
  "Gyeongsangnam-do",
  "Jeju-do",
];
const foots = ["left", "right"];

export default function SignUpSide() {
  let navigate = useNavigate();
  const classes = useStyles();
  const [regist, setRegist] = useState({
    name: "",
    email: "",
    password: "",
    birthDate: "",
    phoneNumber: "",
    address: "",
    addressDetail: "",
    sportExperience: "",
    preferredPosition: "",
    preferredRegion: "",
    foot: "",
    weight: "",
    height: "",
    nationality: "",
  });

  const changeData = (e) => {
    const nextRegist = {
      ...regist,
      [e.target.name]: e.target.value,
    };
    setRegist(nextRegist);
  };

  const handleSubmit = () => {
    if (true) {
      const apiParam = regist;

      apiService
        .post("player/regist", apiParam)
        .then((response) => {
          navigate("/login");
        })
        .catch(({ response }) => {
          console.log(response);
        });
    }
  };

  return (
    <Grid container component='main' className={classes.root}>
      <Grid item xs={false} sm={4} md={7} className={classes.image} />
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
        <div className={classes.paper}>
          <Typography component='h1' variant='h5'>
            Sign up
          </Typography>
          <div className={classes.form} onSubmit={handleSubmit}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  autoComplete='fname'
                  name='name'
                  variant='outlined'
                  required
                  fullWidth
                  id='name'
                  label='Name'
                  autoFocus
                  value={regist.name}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  id='email'
                  label='Email Address'
                  name='email'
                  autoComplete='email'
                  value={regist.email}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  name='password'
                  label='Password'
                  type='password'
                  id='password'
                  autoComplete='new-password'
                  value={regist.password}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  required
                  fullWidth
                  name='birthDate'
                  label='Birth Date'
                  type='date'
                  id='birthDate'
                  InputLabelProps={{
                    shrink: true,
                  }}
                  value={regist.birthDate}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='phoneNumber'
                  label='Phone Number'
                  id='phoneNumber'
                  autoComplete='tel'
                  value={regist.phoneNumber}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='address'
                  label='Address'
                  id='address'
                  autoComplete='street-address'
                  value={regist.address}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='addressDetail'
                  label='Address Detail'
                  id='addressDetail'
                  autoComplete='off'
                  value={regist.addressDetail}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12}>
                <Typography variant='subtitle1'>Sport Experience</Typography>
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='sportExperience'
                  label='Experience'
                  id='sportExperience'
                  autoComplete='off'
                  value={regist.sportExperience}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='position-select-label'>
                    Preferred Position
                  </InputLabel>
                  <Select
                    labelId='position-select-label'
                    id='position-select'
                    name='preferredPosition'
                    label='Preferred Position'
                    value={regist.preferredPosition}
                    onChange={(e) => changeData(e)}
                  >
                    {positions.map((position) => (
                      <MenuItem key={position} value={position}>
                        {position}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
              </Grid>
              <Grid item xs={12} sm={6}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='region-select-label'>
                    Preferred Region
                  </InputLabel>
                  <Select
                    labelId='region-select-label'
                    id='region-select'
                    name='preferredRegion'
                    label='Preferred Region'
                    value={regist.preferredRegion}
                    onChange={(e) => changeData(e)}
                  >
                    {regions.map((region) => (
                      <MenuItem key={region} value={region}>
                        {region}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
              </Grid>
              <Grid item xs={12} sm={6}>
                <FormControl variant='outlined' fullWidth>
                  <InputLabel id='foot-select-label'>Preferred foot</InputLabel>
                  <Select
                    labelId='foot-select-label'
                    id='foot-select'
                    name='foot'
                    label='Preferred foot'
                    value={regist.foot}
                    onChange={(e) => changeData(e)}
                  >
                    {foots.map((foot) => (
                      <MenuItem key={foot} value={foot}>
                        {foot}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='weight'
                  label='Weight'
                  id='weight'
                  autoComplete='off'
                  InputProps={{
                    endAdornment: (
                      <InputAdornment position='end'>kg</InputAdornment>
                    ),
                  }}
                  value={regist.weight}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='height'
                  label='Height'
                  id='height'
                  autoComplete='off'
                  InputProps={{
                    endAdornment: (
                      <InputAdornment position='end'>cm</InputAdornment>
                    ),
                  }}
                  value={regist.height}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant='outlined'
                  fullWidth
                  name='nationality'
                  label='Nationality'
                  id='nationality'
                  autoComplete='off'
                  value={regist.nationality}
                  onChange={(e) => changeData(e)}
                />
              </Grid>
            </Grid>
            <Button
              type='submit'
              fullWidth
              variant='contained'
              color='primary'
              className={classes.submit}
              onClick={handleSubmit}
            >
              Sign Up
            </Button>
            <Grid container justify='flex-end'>
              <Grid item>
                <Link href='/login' variant='body2'>
                  Already have an account? Sign in
                </Link>
              </Grid>
            </Grid>
          </div>
        </div>
      </Grid>
    </Grid>
  );
}
