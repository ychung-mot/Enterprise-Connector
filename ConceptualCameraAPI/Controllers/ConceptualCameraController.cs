using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ConceptualCameraAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ConceptualCameraController : ControllerBase
    {
        private readonly ILogger<ConceptualCameraController> _logger;

        public ConceptualCameraController(ILogger<ConceptualCameraController> logger)
        {
            _logger = logger;
        }

        // GET: MOTICamera/ping
        [HttpGet("ping")]
        public async Task<ActionResult> GetPing()
        {
            return Ok("pong");
        }

        // GET: MOTICamera/Cameras
        [HttpGet("Cameras")]
        public async Task<ActionResult> GetCameras(int id)
        {
            return Ok("A list of cameras");
        }

        // GET: MOTICamera/Camera/{id}
        [HttpGet("Camera/{id}")]
        public async Task<ActionResult> GetCamera(int id)
        {
            return Ok("Information about a camera");
        }

        // GET: MOTICamera/Camera/{id}/Image
        [HttpGet("Camera/{id}/Image")]
        public async Task<ActionResult> GetCameraImage(int id)
        {
            return Ok("Information about the image from a camera + image");
        }

        // GET: MOTICamera/Camera/{id}/Video
        [HttpGet("Camera/{id}/Video")]
        public async Task<ActionResult> GetCameraVideo(int id)
        {
            return Ok("Information about the camera video stream");
        }
    }
}
