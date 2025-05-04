#version 150

in vec2 texCoord0;
out vec4 fragColor;

uniform sampler2D Sampler0;


void main() {
    fragColor = texture(Sampler0, texCoord0);
}
